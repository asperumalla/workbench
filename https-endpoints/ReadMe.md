The purpose of this code is to test the self-singned certificates.

use the below command to generate the certificate:

keytool -genkey -alias skipper -keyalg RSA -keystore skipper.keystore \
-validity 3650 -storetype JKS \
-dname "CN=localhost, OU=Spring, O=Pivotal, L=Holualoa, ST=HI, C=US"
-keypass skipper -storepass skipper

Now, take a look at how maaping is happeing at Spring application properties.

Not saving the keystore file.

reference from : https://docs.spring.io/spring-cloud-skipper/docs/1.0.0.BUILD-SNAPSHOT/reference/html/configuration-security-enabling-https.html