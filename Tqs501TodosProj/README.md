# Build
mvn clean package && docker build -t tqsua/TodosProj .

# RUN

docker rm -f TodosProj || true && docker run -d -p 8080:8080 -p 4848:4848 --name TodosProj tqsua/TodosProj 