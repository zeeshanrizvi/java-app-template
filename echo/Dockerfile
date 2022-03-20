FROM openjdk
COPY src echo
WORKDIR echo
RUN mkdir -p bin
RUN javac -version
RUN javac -d bin ./echo/Main.java
WORKDIR bin
CMD ["java", "echo.Main"]

