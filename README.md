## To run the application

Run the command at the root of the application

`mvn clean spring-boot:run`

Then send a POST request to http://localhost:8080/hoover

## Input

Program input should be sent in a json payload with the format described here.

Example:

```javascript
{
  "roomSize" : [5, 5],
  "coords" : [1, 2],
  "patches" : [
    [1, 0],
    [2, 2],
    [2, 3]
  ],
  "instructions" : "NNESEESWNWW"
}
```

## Output

Service output should be returned as a json payload.

Example (matching the input above):

```javascript
{
  "coords" : [1, 3],
  "patches" : 1
}
```
