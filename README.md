# uppercasems

## Overview
A simple Containerised Springboot based microservice that will convert strings to uppercase.

Project uses maven.

The **build** script generates the docker container **uppercasems**

The container presents on port 8090 and responds to **Get** requests such that :-

    <ipaddress>:8090/somestring

    returns

    SOMESTRING
