.PHONY: build clean run

build: tema1

run:
	java MainClass

tema1:
	javac *.java

clean:
	rm -rf *.class
