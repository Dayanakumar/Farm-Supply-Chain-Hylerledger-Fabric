# Farm-Supply-Chain-Hylerledger-Fabric
Farm Supply Chain Project using Hyperledger Fabric/Java/Gradle/Chaincode/Fabric TestNetwork

Recommended technologies:
1.	IDE Tool: Eclipse
2.	Chaincode Language: Java
3.	Build Automation tool: Gradle
4.	Blockchain: Hyperledger Fabric
5.	Server: Test network

Food quality and safety are important topics today as everyone is concerned about the quality of the food that is being consumed. 
Food items like fruits and vegetables generally do not have any expiry date mentioned so it becomes really important to understand the origin of these food items and know when was it sent to the distributor from the farmer and so on. The following cycle is generally followed in the fruit supply chain:
1.	Producer: The producer can harvest fruits and vegetables, sell them to a distributor, and track authenticity.
2.	Distributor: The distributor can buy and distribute the fruits and track authenticity.
3.	Retailer: The retailer can buy and put the fruits for sale and track authenticity.
4.	Consumer: The consumer can buy the fruits and track authenticity.

Features of the application:
1.	Farm Product has the following parameters:
a.	productId: Asset Id
b.	productDescription: Description of the asset
c.	producerName: Name of the producer or farmer
d.	producerAddress: Address of the producer or farmer
e.	harvestDate: Date of the harvest
f.	distributerName: Name of the distributer
g.	distributerAddress: Address of the distributer
h.	prodToDistDate: Date of transfer from producer to distributer
i.	retailerName: Name of the retailer
j.	retailerAddress: Address of the retailer 
k.	distToRetaDate: Date of transfer from distributer to retailer
