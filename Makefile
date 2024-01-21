# Makefile for Java application

# Variables
JAVAC = javac
JAVA = java
SRC = .
BUILD = build
MAINCLASS = YourMainClass

# Compile Java files into the build directory
build: $(SRC)/*.java
	mkdir -p $(BUILD)
	$(JAVAC) -d $(BUILD) $(SRC)/*.java

# Run the application
run: build
	$(JAVA) -cp $(BUILD) $(MAINCLASS)

# Clean, build and run the app
all: clean build run

# Clean the build directory
clean:
	rm -rf $(BUILD)

.PHONY: build run clean all
