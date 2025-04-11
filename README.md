# SpringAI

A Spring Boot application for interacting with **AI models**, built with **Gradle** and using **Ollama** for local AI model execution.

## Author

**Syed Aeliya M Taqvi**  
Email: [syedaeliya.taqvi@gmail.com](mailto:syedaeliya.taqvi@gmail.com)

## Prerequisites

Before running the application, ensure you have the following:

- **Gradle Version**: 8.13
- **Java Version**: 21
- **Ollama**: A local AI model framework that needs to be installed separately.

## Getting Started

### 1. **Clone the Repository**

Clone this repository to your local machine:

```bash
git clone <your-repository-url>
cd <your-project-folder>
```

### 2. **Install Prerequisites**

#### 2.1 **Install Gradle (if not already installed)**

- Follow the instructions for your platform at [Gradle Installation](https://gradle.org/install/).

#### 2.2 **Install Java 21**

- Follow the installation guide at [OpenJDK Downloads](https://jdk.java.net/21/) to get **Java 21** installed.

#### 2.3 **Download and Install Ollama**

Ollama is an open-source framework for running AI models locally. You’ll need to install it before you can use the AI models.

- **Install Ollama**: Visit [Ollama's website](https://ollama.com/download) and download the latest version for your OS.

Once Ollama is installed, ensure it is running correctly by checking its version:

```bash
ollama --version
```

#### 2.4 **Download AI Model (DeepSeek)**

The application uses the **DeepSeek** AI model. Once Ollama is installed, you need to download the **DeepSeek** model. You can use the following command to pull the model:

```bash
ollama pull deepseek-r1:1.5b
```

This will download the **DeepSeek model** locally, so it can be used for generating responses in your Spring application.

> **Note**: Depending on your machine’s capacity, you can change the model to a larger or smaller one. Ollama supports multiple model sizes, such as **`deepseek-r1:7b`**, **`deepseek-r1:8b`**, and more. Larger models may require more computational resources, so choose a model that best matches your system's capabilities. You can modify the model size in the **`application.properties`** file like so:

```properties
spring.application.name=SpringAI
spring.ai.ollama.chat.options.model=deepseek-r1:7b  # Change to 7b, 8b, or others based on your machine's capacity
```

---

### 3. **Configure `application.properties`**

Make sure the **`application.properties`** file is correctly configured. It should look like this:

```properties
spring.application.name=SpringAI
spring.ai.ollama.chat.options.model=deepseek-r1:1.5b  # Or change this to any other model like 7b, 8b
```

The `model` property defines which Ollama model to use locally. In this case, it’s set to use **DeepSeek (version 1.5b)**, but you can switch to a different version, depending on your machine’s available resources.

---

### 4. **Build and Run the Application**

#### 4.1 **Build the Application**

Use **Gradle** to build the application:

```bash
gradle build
```

#### 4.2 **Run the Application**

Run the Spring Boot application using the following command:

```bash
gradle bootRun
```

Once the application is running, you can test the endpoints by sending requests to:

```bash
http://localhost:8080/getMeAnAnswer?question=Your+Question+Here
```

This will interact with the **DeepSeek model** and return a response.

---

### 5. **How It Works**

- The application uses **Ollama** to load and interact with the **DeepSeek** model locally.
- When you send a request to the endpoint, the controller sends the `question` to the **AI engine**, which processes it using the loaded model, and sends a response back.

---

### 6. **Troubleshooting**

If you encounter any issues, here are some common fixes:

- **Ollama not found**: Ensure that Ollama is correctly installed and added to your `PATH`.
- **Model download issues**: If you can’t pull the model, check your network connection or try running the `ollama pull` command manually.
- **Java version issues**: Ensure that **Java 21** is set up properly by running `java -version` to check your version.

---