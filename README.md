# Java Spring Boot - Mini DevOps CI/CD Assessment

# Objective

Build an end-to-end CI/CD pipeline to automate the build, Docker image creation, Docker image push, and Kubernetes deployment of a Spring Boot Inventory REST API.

---

## REST Endpoints

Method| Endpoint| Description
GET| "/health"| Health check
GET| "/products"| Retrieve all products
POST| "/products"| Add a new product

Use an in-memory list. No database is required.

---

## Module 1 - Run the Application
Run using the jenkins Server on Local Host (8080)
---

## Module 2 - Dockerize the Application

Create a "Dockerfile".

Verify that:

- Docker image builds successfully.
- Application runs inside a container.
- "/health" endpoint is accessible.

---

## Module 3 - Jenkins Pipeline
//Due to unavailability of creds. Commented out the further parts

Create a Declarative "Jenkinsfile" with the following stages:

1. Checkout
2. Maven Build
3. Docker Build
4. Docker Push

Image naming format:

<dockerhub-username>/java-inventory-api:${BUILD_NUMBER}

---

## Module 4 - Kubernetes Deployment

Create:

- "deployment.yaml"
- "service.yaml"

Requirements:

- Replicas = 2
- Service Type = NodePort

Deploy:

kubectl apply -f deployment.yaml
kubectl apply -f service.yaml

Verify:

kubectl get pods
kubectl get svc

---

## Deliverables

- Spring Boot Source Code
- Dockerfile
- Jenkinsfile
- deployment.yaml
- service.yaml
- Jenkins Success Screenshot
- Docker Hub Screenshot
- Kubernetes Pods Screenshot
- Application Output Screenshot 
