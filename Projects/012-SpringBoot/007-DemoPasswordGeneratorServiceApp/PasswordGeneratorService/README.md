- Uygulamanın curl için POST olarak request'i:

```curl
curl -d "{\"username\": \"oguz\", \"password\": \"csd1993\", \"textCount\": 6, \"textLength\": 4}" -H "Content-Type: application/json" -X POST "http://localhost:6767/api/generator/password/generate"
```

veya

```curl
curl -d "{\"username\": \"oguz\", \"password\": \"csd1993\", \"textCount\": 6, \"textLength\": 4}" -H "Content-Type: application/json" -X POST "http://172.26.16.1:6767/api/generator/password/generate"

veya

```curl
curl -d "{\"username\": \"deniz\", \"password\": \"csd1993\", \"textCount\": 6, \"textLength\": 4}" -H "Content-Type: application/json" -X POST "http://172.26.16.1:50500/api/generator/password/generate"
```