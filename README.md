# osfamicroservice

## Overview
A simple containerised Springboot based microservice that can be spun up to provide different microservices depending on a passed in environment variable
    -e OSFAMS_SERVICE='upper'|'lower'|'reversed'|'braced'|'unbraced'

Simulate container failure by supplying a count of requests to be processed before exiting with the environment variable:-
    -e OSFAMS_TIME_TO_LIVE='99'

Chain further MicroService by specifying the address:port of next MicroService in the Chain
    -e OSFAMS_CHAINED_MS='somehost:port'


Project uses maven.


The **build** script generates the docker container **osfamicroservice**. This assumes that the maven build has already created the jar file ready for deployment.

    docker run -e OSFAMS_TIME_TO_LIVE='5' -e OSFAMS_SERVICE='upper' -p 8090:8090 --rm osfamicroservice


    docker run -e OSFAMS_CHAINED_MS='<some host>:someport'-e OSFAMS_TIME_TO_LIVE='3' -e OSFAMS_SERVICE='reversed' -p 8090:8090 --rm osfamicroservice

    

There is also simple Jenkins pipeline defined in **Jenkinsfile** which runs the build and tests to ensure everything is OK.

The container presents on port 8090 and responds to **Get** requests such that,for example, a container running as OSFAMS_SERVICE='upper' would :-

    <ipaddress>:8090/somestring

    returns

    SOMESTRING
