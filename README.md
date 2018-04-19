# ApplianceControl
This spring boot-based application is able to persist Oven and WashMachine json representations to the internal embedded HSQLDB using Spring Data JPA as well as their temporary states. It also can return current state of requested appliance entity.

## Build and install
Application uses Gradle to build jar that is ready to run. Application is available on localhost:8080 by default.

## Tests
Application contains built-in unit tests, that check:
- mapping objects between dto and JPA entities
- JPA repositories internal implementation

## Application API
Application supports basic operations on appliance types oven and wash machine:
* Create new oven object:
'''
curl -H "Content-Type: application/json;charset=UTF-8" -d "{\"model\": \"123QWE\", \"modelYear\": 2015}" http://localhost:8080/oven/create
'''
'''
{"id":1,"type":"OVEN","model":"123QWE","modelYear":2015}
'''
* Create new wash machine object:
'''
curl -H "Content-Type: application/json;charset=UTF-8" -d "{\"model\": \"TEST\"}" http://localhost:8080/washMachine/create
'''
'''
{"id":2,"type":"WASH_MACHINE","model":"TEST"}
'''
* Assign state to appliance entity that is created earlier:
'''
curl -H "Content-Type: application/json;charset=UTF-8" -d "{\"state\": \"STANDBY\"}" http://localhost:8080/applianceState/2/change
'''
and after that
'''
curl -H "Content-Type: application/json;charset=UTF-8" -d "{\"state\": \"OFF\"}" http://localhost:8080/applianceState/2/change
'''
* Give appliance entity with last assigned state:
'''
curl http://localhost:8080/washMachine/2
'''
'''
{"id":2,"type":"WASH_MACHINE","model":"TEST","state":{"timestamp":"2018-04-19 01:15:31.984","state":"OFF"}}
'''
It returns UNKNOWN state in a case of state is not assigned yet:
'''
curl http://localhost:8080/oven/1
'''
'''
{"id":1,"type":"OVEN","model":"123QWE","state":{"timestamp":"2018-04-19 01:17:33.0","state":"UNKNOWN"},"modelYear":2015}
'''
* Application is able to return clean last state of entity:
'''
curl -H "Content-Type: application/json;charset=UTF-8" -d "{\"state\": \"ON\"}" http://localhost:8080/applianceState/1/change
'''
'''
curl http://localhost:8080/applianceState/1
'''
'''
{"timestamp":"2018-04-19 01:18:08.019","state":"ON"}
'''
'''
curl http://localhost:8080/applianceState/2
'''
'''
{"timestamp":"2018-04-19 01:15:31.984","state":"OFF"}
'''

Note: State is detached from the entity cause it may frequently change. I assume NOSQL as a storage for appliance states. Current implementation uses embedded relational database.
