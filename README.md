# uppercasems

## Overview
A simple Containerised Springboot based microservice that will convert strings to uppercase.

Project uses maven.

The **build** script generates the docker container **uppercasems**. This assumes that the maven build has already created the jar file ready for deployment.

There is also simple Jenkins pipeline defined in **Jenkinsfile** which runs the build and tests to ensure everything is OK.

The container presents on port 8090 and responds to **Get** requests such that :-

    <ipaddress>:8090/somestring

    returns

    SOMESTRING
