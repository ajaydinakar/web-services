# web-services

## Overview

The `web-services` repository demonstrates the implementation of various types of web services in Java, focusing on SOAP-based services. It covers multiple web service technologies, security configurations, file transfer using MTOM (Message Transmission Optimization Mechanism), and JAXB (Java Architecture for XML Binding) for XML data binding. The project is organized into several submodules, each focusing on a specific aspect or technology related to web services.

---

## Purpose

The repository is intended as a comprehensive educational resource and reference implementation for:

- Creating and exposing SOAP web services in Java.
- Enabling secure communication using WS-Security (UsernameToken).
- Transferring files efficiently over SOAP with MTOM.
- Generating and using Java classes from XML schemas via JAXB.
- Demonstrating compatibility across different Java versions (Java 8 and Java 17).

---

## Main Features

- **SOAP Web Services:** Multiple modules implement SOAP endpoints with Apache CXF and Spring.
- **MTOM File Transfer:** Efficient upload and download of binary files using SOAP with MTOM encoding.
- **WS-Security:** Secure endpoints using UsernameToken authentication via WSS4J.
- **JAXB Integration:** XML schema-based class generation and usage.
- **Version Compatibility:** Examples provided for both Java 8 and Java 17 environments.
- **Client Example:** Includes a sample SOAP client with security configuration.

---

## Architecture & Key Modules

### 1. `hellowebservicejava8` and `hellowebserviceJava17`
- **Purpose:** Provide simple SOAP web service examples compatible with Java 8 and Java 17.
- **Key Classes:**
  - `HelloWs.java`: SOAP service returning a sample string.
  - `WebserviceConfig.java`: Spring configuration that publishes the endpoint at `/hello`.
- **Features:** Demonstrate how to define and expose a basic SOAP service; includes logging features via CXF.

### 2. `mtom`
- **Purpose:** Demonstrates file upload and download over SOAP using MTOM.
- **Key Classes:**
  - `FileWS.java`: SOAP interface defining `upload(DataHandler)` and `download()` methods.
  - `FileWSImpl.java`: Implementation that writes uploaded files to disk and serves them for download.
  - `WebserviceConfig.java`: Publishes the MTOM-enabled endpoint at `/fileWS`.
- **How It Works:**
  - `upload`: Receives a file as a `DataHandler`, writes it to a specified path.
  - `download`: Reads the file from disk and returns it as a `DataHandler`.
  - MTOM is enabled to optimize transmission of binary data.

### 3. `javafirstws`
- **Purpose:** Implements a Java-first (code-first) SOAP web service with WS-Security.
- **Key Classes:**
  - `WebserviceConfig.java`: Publishes an endpoint at `/paymentProcessor` with security interceptors.
  - Integrates WSS4J for UsernameToken authentication.
- **Security Configuration:**
  - Sets up security properties (action, password type, callback class).
  - Adds a security interceptor to the endpoint to enforce username/password authentication.

### 4. `jaxbxjc`
- **Purpose:** Contains JAXB-generated Java classes from XML Schema (XSD).
- **Key Classes:**
  - `ObjectFactory.java`: Factory for creating new instances of schema-derived classes.
  - `Patient.java`, `Insurance.java`, etc.: Represent schema-derived data objects.
- **How It Works:**
  - Used for marshalling/unmarshalling XML data to/from Java objects in web services.

### 5. `utclient`
- **Purpose:** Example SOAP client with security configuration.
- **Key Classes:**
  - `PaymentWSClient.java`: Demonstrates how to call the `PaymentProcessor` web service securely.
  - Configures UsernameToken security using WSS4J interceptors.

---

## Key Files

- `HelloWs.java`: Example SOAP service class.
- `WebserviceConfig.java`: Spring configuration and endpoint publication for various modules.
- `FileWS.java`/`FileWSImpl.java`: MTOM-enabled file transfer interfaces and implementations.
- `ObjectFactory.java`, `Patient.java`, `Insurance.java`: JAXB-generated classes for XML data binding.
- `PaymentWSClient.java`: Example SOAP client setup with security.

---

## Example: MTOM File Upload/Download

- **Upload:** The client sends a file as a `DataHandler` object to the `upload` endpoint, which writes the file to disk.
- **Download:** The service reads a file from disk and sends it back as a `DataHandler` for the client to retrieve.
- **MTOM:** The use of MTOM ensures large files are transmitted efficiently as binary attachments.

---

## Example: WS-Security with UsernameToken

- Security properties are configured in `WebserviceConfig.java` with interceptors.
- The client (`PaymentWSClient.java`) adds the appropriate WS-Security headers (username, password).
- The server validates credentials via callback.

---

## Summary

This repository is a practical, modular showcase of Java web service technologies. It covers:

- Service implementation and endpoint configuration with Apache CXF and Spring.
- Secure SOAP communication using WS-Security (UsernameToken).
- Binary file transfer via MTOM.
- JAXB for XML data binding.
- Multi-version Java support.
- Example SOAP client code with security.

It is ideal for learning, prototyping, or reference when building robust web service solutions in Java.

---
