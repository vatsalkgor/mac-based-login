package macaddress;

import java.net.NetworkInterface;
import java.net.SocketException;

/**
 *
 * @author Vatsal
 */
public class MacLogin {

    private static final Hashing hash = new Hashing();
    private static String macAddress;

    public MacLogin(String macAddress) {
        this.macAddress = hash.hashpass(macAddress);
    }

    protected boolean compareMAC(String mac) {
        if (!mac.equals("")) {
            String hashMac = hash.hashpass(mac);
            if (hashMac.equals(macAddress)) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    protected String getMac() throws SocketException {
        String mac = "";
        //This basically gets only two of the NICs which are ethernet card named eth0 and eth1;
        NetworkInterface eth = NetworkInterface.getByName("eth0");
        NetworkInterface eth1 = NetworkInterface.getByName("eth1");
        //This gets the MAC Address of both the NICs. 
        byte[] ethAdd = eth.getHardwareAddress();
        byte[] ethAdd1 = eth1.getHardwareAddress();
        if (ethAdd != null) {
            for (int i = 0; i < ethAdd.length; i++) {
                mac = mac.concat(String.format("%02X%s", ethAdd[i], (i < ethAdd.length - 1) ? "-" : ""));
            }
        } else if (ethAdd1 != null) {
            for (int i = 0; i < ethAdd1.length; i++) {
                mac = mac.concat(String.format("%02X%s", ethAdd1[i], (i < ethAdd1.length - 1) ? "-" : ""));
            }
        }
        //If both of the cards are working then it will return the eth1's mac address in FF-FF-FF-FF-FF-FF form. 
        return mac;
    }
}
