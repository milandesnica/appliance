
admin interface
===============
To load appliances  into the database, use the following rest command (using curl or postman):

localhost:8080/api/admin/appliance/load 

THe appliance JSON is in a file under resources and should be loaded into the body of the request.


If you want appliances to have existing connections, then use:

localhost:8080/api/admin/appliance/load?testDataConnections=true


To load customer into the database, use the following rest command (using curl or postman):

localhost:8080/api/admin/customer/load

The customer JSON is in a file under resources and should be loaded into the body of the request.

appliance interface
==================
localhost:8080/api/appliances/sortedByConnections?order=asc , will sort the appliances by number of connections in ascending order.

localhost:8080/api/appliances/sortedByConnections?order=desc , will sort the appliances by number of connections in descending order.


// implementation of poller
The appliance polling mechanism is accessing an interface that is implemented in a simple way:
It just by a random factor, sets connections to true or false, simulating a connection to the appliance.


The scheduler runs once in a minute. It is for simplicity hardcoded in the Scheduler class.