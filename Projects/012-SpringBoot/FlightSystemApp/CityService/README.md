- Uygulamanın curl için POST olarak request'i:

```curl
curl -d "{\"name\": \"Berlin\", \"countryId\": 1}" -H "Content-Type: application/json" -X POST "http://localhost:6767/api/system/flight/city/add"
```

```curl
curl -d "{\"name\": \"Ankara\", \"countryId\": 1000}" -H "Content-Type: application/json" -X POST "http://localhost:6767/api/system/flight/city/add"
```
