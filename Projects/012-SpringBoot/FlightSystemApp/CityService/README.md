Uygulamanın curl için 

- POST olarak request'i:
```curl
curl -d "{\"name\": \"Berlin\", \"countryId\": 5}" -H "Content-Type: application/json" -X POST "http://localhost:6767/api/system/flight/city/add"
```

- DELETE olarak request'i:
```curl
curl -X DELETE "http://localhost:6767/api/system/flight/city/delete/1"
```

- GET olarak request'i:
```curl
curl "http://localhost:6767/api/system/flight/city/find/1"
```
```curl
curl "http://localhost:6767/api/system/flight/city/find?name=Zonguldak"
```
```curl
curl "http://localhost:6767/api/system/flight/city/find/all"
```