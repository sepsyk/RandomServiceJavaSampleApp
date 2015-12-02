#!/bin/bash
#test if response contains message and rand strings
response=$(curl -X POST -d '{"message": "something"}' http://127.0.0.1:8080/api)
if [[ $response == *"message"* && $response == *"rand"* ]]; then
echo "Response contains expected message attributes (message, rand) - test passed"
exit 0
else
echo "Response does not contain expected message attributes (message, rand) - test failed"
exit 1
fi
