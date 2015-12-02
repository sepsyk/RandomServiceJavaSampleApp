#/!bin/bash

response=$(curl -s -o /dev/null -X POST -d '{"message": "something"}' http://127.0.0.1:8080/api -w "%{http_code}")
if [ $response -eq 200 ]; then 
echo "HTTP Response code: $response - test passed"
exit 0 
else 
echo "HTTP Reponse code: $response - test errored"
exit 1 
fi
