# API Spec Ticket Reservation

Demo : https://ticketcinemafilmsservice.up.railway.app/swagger-ui/index.html

- Film
- Seat
- Schedule


## Film

### Create Film
Request :
- Method : POST
- EndPoint : `/api/film/add`
- Header :
    - Authorization : bearer token
    - Content-Type : application/json
    - Accept : application/json
- Body :

```json
{
  "films":{
    "filmCode": "String",
    "filmName": "String",
    "isShow": "Show",
    "schedules": [
      {
        "showDate": "2022-11-28",
        "startingHour": "12.00",
        "endingHour": "13.00",
        "ticketPrice": "50000"
      },{
        "showDate": "2022-11-28",
        "startingHour": "16.00",
        "endingHour": "17.00",
        "ticketPrice": "60000"
      },{
        "showDate": "2022-11-28",
        "startingHour": "20.00",
        "endingHour": "21.00",
        "ticketPrice": "40000"
      }
    ]
  }
}
```

- Response :

```json
{
  "status": "number",
  "message": "string",
  "data": {
    "idFilm": "Integer, unique",
    "filmCode": "String",
    "filmName": "String",
    "isShow": "String",
    "schedules": [
      {
        "idSchedule": 69,
        "showDate": "2022-11-28",
        "startingHour": "12.00",
        "endingHour": "13.00",
        "ticketPrice": "50000"
      },
      {
        "idSchedule": 70,
        "showDate": "2022-11-28",
        "startingHour": "16.00",
        "endingHour": "17.00",
        "ticketPrice": "60000"
      },
      {
        "idSchedule": 71,
        "showDate": "2022-11-28",
        "startingHour": "20.00",
        "endingHour": "21.00",
        "ticketPrice": "40000"
      }
    ]
  }
}
```

### Update Film

Request :

- Method : PUT
- EndPoint : `api/film/update`
- Header :
    - Authorization : bearer token
    - Content-Type : application/json
    - Accept : application/json
- Body :
```json
{
  "idFilm": "Integer, unique",
  "filmCode": "String",
  "filmName": "String",
  "isShow": "String"
}
```

- Response :

```json
{
  "code": "number",
  "status": "string",
  "data": {
    "idFilm": "Integer, unique",
    "filmCode": "String",
    "filmName": "String",
    "isShow": "String"
  }
}
```

### Delete Film

Request :

- Method : DELETE
- EndPoint : `api/film/delete?{id}`
- Header :
    - Authorization : bearer token
    - Accept : application/json
- Response :

```json
{
  "code": "number",
  "status": "string"
}
```

### List Film

Request :

- Method : GET
- EndPoint : `/api/film/getAllFilm`
- Header :
    - Authorization : bearer token
    - Accept : application/json
- Response :

```json
{
  "code": "number",
  "status": "string",
  "data": [
    {
      "idFilm": "Integer, unique",
      "filmCode": "Long",
      "filmName": "String",
      "isShow": "String"
    },
    {
      "idFilm": "Integer, unique",
      "filmCode": "Long",
      "filmName": "String",
      "isShow": "String"
    }
  ]
}
```

### Get Film by id

Request :

- Method : GET
- EndPoint : `/films/search/{id_film}`
- Header :
    - Accept : application/json
- Response :

```json
{
  "status": "number",
  "message": "string",
  "data": [
    {
      "filmName": "string",
      "isShow": "string",
      "showDate": "2022-11-25",
      "startingHour": "12.00",
      "endingHour": "13.00",
      "ticketPrice": "50000"
    },
    {
      "filmName": "string",
      "isShow": "string",
      "showDate": "2022-11-25",
      "startingHour": "16.00",
      "endingHour": "17.00",
      "ticketPrice": "60000"
    }
  ]
}
```

### Get Film by name

Request :

- Method : GET
- EndPoint : `/api/film/search?`
- Header :
    - Authorization : bearer token
    - Accept : application/json
- Params :

```json
{
  "filmName": "String"
}
```

- Response :

```json
{
  "status": "number",
  "message": "string",
  "data": [
    {
      "filmName": "string",
      "isShow": "string",
      "showDate": "2022-11-25",
      "startingHour": "12.00",
      "endingHour": "13.00",
      "ticketPrice": "50000"
    },
    {
      "filmName": "string",
      "isShow": "string",
      "showDate": "2022-11-25",
      "startingHour": "16.00",
      "endingHour": "17.00",
      "ticketPrice": "60000"
    }
  ]
}
```

### Get Film by is Showing
Request :
- Method : GET
- EndPoint : `/api/film/getFilmsShow`
- Header :
    - Accept : application/json
- Response :

```json
{
  "status": "number",
  "message": "string",
  "data": [
    {
      "filmName": "string",
      "isShow": "string",
      "showDate": "2022-11-25",
      "startingHour": "12.00",
      "endingHour": "13.00",
      "ticketPrice": "50000"
    },
    {
      "filmName": "string",
      "isShow": "string",
      "showDate": "2022-11-25",
      "startingHour": "16.00",
      "endingHour": "17.00",
      "ticketPrice": "60000"
    }
  ]
}
```

### Get Schedule by film name
Request :
- Method : GET
- EndPoint : `/api/film/getFilmsSchedule?film_name=`
- Header :
    - Authorization : bearer token
    - Accept : application/json
- Params :

```json
{
  "filmName": "String"
}
```

- Response :

```json
{
  "code": "number",
  "status": "string",
  "data": [
    {
      "idFilm": "Integer, unique",
      "filmCode": "Long",
      "filmName": "String",
      "isShow": "String",
      "Schedules": {
        "showDate": "String",
        "startingHour": "String",
        "ticketPrice": "String"
      }
    },
    {
      "idFilm": "Integer, unique",
      "filmCode": "Long",
      "filmName": "String",
      "isShow": "String",
      "Schedules": {
        "showDate": "String",
        "startingHour": "String",
        "ticketPrice": "String"
      }
    }
  ]
}
```







## Seats

### Create Seats

Request :

- Method : POST
- EndPoint : `/api/seats/add`
- Header :
    - Authorization : bearer token
    - Content-Type : application/json
    - Accept : application/json
- Body :

```json
{
  "seatId": {
    "studioName": "Character",
    "seatNo": "Integer"
  },
  "status": "String"
}
```
- Response :
```json
{
  "code": "number",
  "status": "string",
  "data": {
    "seatId": {
      "studioName": "Character",
      "seatNo": "Integer"
    },
    "status": "String"
  }
}
```

### Update Seats
Request :

- Method : PUT
- EndPoint : `/api/seats/update`
- Header :
    - Authorization : bearer token
    - Content-Type : application/json
    - Accept : application/json
- Body :

```json
{
  "seatId": {
    "studioName": "Character",
    "seatNo": "Integer"
  },
  "status": "String"
}
```

- Response :

```json
{
  "code": "number",
  "status": "string",
  "data": {
    "seatId": {
      "studioName": "Character",
      "seatNo": "Integer"
    },
    "status": "String"
  }
}
```

### List Seats

Request :

- Method : GET
- EndPoint : `/api/seats/getAllSeats`
- Header :
    - Authorization : bearer token
    - Accept : application/json
- Response :

```json
{
  "code": "number",
  "status": "string",
  "data": [
    {
      "seatId": {
        "studioName": "Character",
        "seatNo": "Integer"
      },
      "status": "String"
    },
    {
      "seatId": {
        "studioName": "Character",
        "seatNo": "Integer"
      },
      "status": "String"
    }
  ]
}
```
### Delete Seats

Request :

- Method : DELETE
- EndPoint : `/api/seats/delete`
- Header :
    - Authorization : bearer token
    - Content-Type : application/json
    - Accept : application/json
- Body :

```json
{
  "seatId": {
    "studioName": "Character",
    "seatNo": "Integer"
  }
}
```

- Response :

```json
{
  "code": "number",
  "status": "string"
}
```









## Schedules

### Create Schedules

Request :

- Method : POST
- EndPoint : `/api/schedules/add`
- Header :
    - Authorization : bearer token
    - Content-Type : application/json
    - Accept : application/json
- Body :

```json
{
  "showDate": "2022-12-22",
  "startingHour": "22.00",
  "endingHour": "23.00",
  "ticketPrice": "22222",
  "codeFilm": "Integer, Unique"
}
```

- Response :

```json
{
  "status": "Integer",
  "message": "String",
  "data": {
    "idSchedule": "Integer, Unique",
    "showDate": "2022-12-22",
    "startingHour": "22.00",
    "endingHour": "23.00",
    "ticketPrice": "22222",
    "fsFk": "Integer, Unique"
  }
}
```

### Update Schedules

Request :

- Method : PUT
- EndPoint : `api/schedules/update`
- Header :
    - Authorization : bearer token
    - Content-Type : application/json
    - Accept : application/json
- Body :

```json
{
  "idSchedule": "Integer, Unique",
  "showDate": "2022-12-22",
  "startingHour": "22.00",
  "endingHour": "23.00",
  "ticketPrice": "22222",
  "codeFilm": "Integer, Unique"
}
```

- Response :

```json
{
  "status": "Integer",
  "message": "String",
  "data": {
    "idSchedule": "Integer, Unique",
    "showDate": "2022-12-22",
    "startingHour": "22.00",
    "endingHour": "23.00",
    "ticketPrice": "22222",
    "fsFk": "Integer, Unique"
  }
}
```

### Delete Schedules

Request :

- Method : DELETE
- EndPoint : `api/schedules/delete?{id}`
- Header :
    - Authorization : bearer token
    - Accept : application/json
- Response :
```json
{
  "code": "number",
  "status": "string"
}
```

### List Schedules

Request :

- Method : GET
- EndPoint : `/api/schedules/getAllSchedules`
- Header :
    - Accept : application/json
- Response :

```json
{
  "status": "Integer",
  "message": "String",
  "data": [{
    "idSchedule": "Integer, Unique",
    "showDate": "2022-12-22",
    "startingHour": "22.00",
    "endingHour": "23.00",
    "ticketPrice": "22222",
    "fsFk": "Integer, Unique"
  },{
    "idSchedule": "Integer, Unique",
    "showDate": "2022-12-22",
    "startingHour": "22.00",
    "endingHour": "23.00",
    "ticketPrice": "22222",
    "fsFk": "Integer, Unique"
  }]
}
```

### Get Schedules by FilmId

Request :

- Method : GET
- EndPoint : `/api/schedules/getSchedulesByFilmId?{id}`
- Header :
    - Accept : application/json
- Response :

```json
{
  "status": "Integer",
  "message": "String",
  "data": {
    "idSchedule": "Integer, Unique",
    "showDate": "2022-12-22",
    "startingHour": "22.00",
    "endingHour": "23.00",
    "ticketPrice": "22222",
    "fsFk": "Integer, Unique"
  }
}
```

