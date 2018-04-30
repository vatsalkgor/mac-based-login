# mac-based-login
This is an open source library which provides you a way to secure your application using MAC Filters to login. 

HOW to USE!!!
1. Download the MACAddress.jar.
2. Import it in your project in library.
3. Create a MacLogin class' object with the argument as the mac address you want to check. 
4. Call getMac() from teh object you created to get the eth0 and eth1 mac address of the system on which application is installed. 
5. Then call compareMAC() to check if your software is licensed or not.
