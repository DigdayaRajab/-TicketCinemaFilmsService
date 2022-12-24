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
    "title": "Aquaman",
    "genres": "Action, Adventure, Fantasy",
    "synopsis": "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
    "yearsCategories": "+12",
    "poster": "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/xLPffWMhMj1l50ND3KchMjYoKmE.jpg",
    "backPoster": "https://www.themoviedb.org/t/p/w1920_and_h800_multi_faces/9QusGjxcYvfPD1THg6oW3RLeNn7.jpg",
    "isShow": 0
  }
}
```

- Response :

```json
{
  "status": "200",
  "message": "successful add data",
  "data": {
    "idFilm": 27,
    "title": "Aquaman",
    "genres": "Action, Adventure, Fantasy",
    "synopsis": "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
    "yearsCategories": "+12",
    "poster": "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/xLPffWMhMj1l50ND3KchMjYoKmE.jpg",
    "backPoster": "https://www.themoviedb.org/t/p/w1920_and_h800_multi_faces/9QusGjxcYvfPD1THg6oW3RLeNn7.jpg",
    "schedules": null,
    "show": false
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
  "filmUpdate":{
    "idFilm": 21,
    "title": "ahsiap man",
    "genres": "comedi",
    "synopsis": "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
    "yearsCategories": "+12",
    "poster": "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/xLPffWMhMj1l50ND3KchMjYoKmE.jpg",
    "backPoster": "https://www.themoviedb.org/t/p/w1920_and_h800_multi_faces/9QusGjxcYvfPD1THg6oW3RLeNn7.jpg",
    "isShow": 1
  }
}
```

- Response :

```json
{
  "status": "200",
  "message": "successful update data",
  "data": {
    "idFilm": 21,
    "title": "ahsiap man",
    "genres": "comedi",
    "synopsis": "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
    "yearsCategories": "+12",
    "poster": "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/xLPffWMhMj1l50ND3KchMjYoKmE.jpg",
    "backPoster": "https://www.themoviedb.org/t/p/w1920_and_h800_multi_faces/9QusGjxcYvfPD1THg6oW3RLeNn7.jpg",
    "isShow": 1
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
  "status": "200",
  "message": "successful delete data",
  "data": ""
}
```

### Get Film by id

Request :

- Method : GET
- EndPoint : `/api/film/getFilmById?{id}`
- Header :
  - Accept : application/json
- Response :

```json
{
  "status": "200",
  "message": "successful get data",
  "data": {
    "idFilm": 23,
    "title": "Aquaman",
    "genres": "Action, Adventure, Fantasy",
    "synopsis": "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
    "yearsCategories": "+12",
    "poster": "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/xLPffWMhMj1l50ND3KchMjYoKmE.jpg",
    "backPoster": "https://www.themoviedb.org/t/p/w1920_and_h800_multi_faces/9QusGjxcYvfPD1THg6oW3RLeNn7.jpg",
    "schedules": [],
    "show": false
  }
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
  "status": "200",
  "message": "ok",
  "data": [
    {
      "idFilm": 20,
      "title": "Aquaman",
      "genres": "Action, Adventure, Fantasy",
      "synopsis": "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
      "yearsCategories": "+12",
      "poster": "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/xLPffWMhMj1l50ND3KchMjYoKmE.jpg",
      "backPoster": "https://www.themoviedb.org/t/p/w1920_and_h800_multi_faces/9QusGjxcYvfPD1THg6oW3RLeNn7.jpg",
      "schedules": [],
      "show": false
    },
    {
      "idFilm": 21,
      "title": "ahsiap man",
      "genres": "comedi",
      "synopsis": "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
      "yearsCategories": "+12",
      "poster": "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/xLPffWMhMj1l50ND3KchMjYoKmE.jpg",
      "backPoster": "https://www.themoviedb.org/t/p/w1920_and_h800_multi_faces/9QusGjxcYvfPD1THg6oW3RLeNn7.jpg",
      "schedules": [],
      "show": true
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
  "status": "200",
  "message": "ok",
  "data": [
    {
      "idFilm": 18,
      "title": "Aquaman",
      "genres": "Action, Adventure, Fantasy",
      "synopsis": "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
      "yearsCategories": "+12",
      "poster": "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/xLPffWMhMj1l50ND3KchMjYoKmE.jpg",
      "backPoster": "https://www.themoviedb.org/t/p/w1920_and_h800_multi_faces/9QusGjxcYvfPD1THg6oW3RLeNn7.jpg",
      "schedules": [],
      "show": true
    },
    {
      "idFilm": 19,
      "title": "Aquaman",
      "genres": "Action, Adventure, Fantasy",
      "synopsis": "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
      "yearsCategories": "+12",
      "poster": "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/xLPffWMhMj1l50ND3KchMjYoKmE.jpg",
      "backPoster": "https://www.themoviedb.org/t/p/w1920_and_h800_multi_faces/9QusGjxcYvfPD1THg6oW3RLeNn7.jpg",
      "schedules": [],
      "show": true
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
  "filmName": "Aquaman"
}
```

- Response :

```json
{
  "status": "200",
  "message": "successful get data",
  "data": {
    "idFilm": 23,
    "title": "Aquaman",
    "genres": "Action, Adventure, Fantasy",
    "synopsis": "Once home to the most advanced civilization on Earth, Atlantis is now an underwater kingdom ruled by the power-hungry King Orm. With a vast army at his disposal, Orm plans to conquer the remaining oceanic people and then the surface world. Standing in his way is Arthur Curry, Orm's half-human, half-Atlantean brother and true heir to the throne.",
    "yearsCategories": "+12",
    "poster": "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/xLPffWMhMj1l50ND3KchMjYoKmE.jpg",
    "backPoster": "https://www.themoviedb.org/t/p/w1920_and_h800_multi_faces/9QusGjxcYvfPD1THg6oW3RLeNn7.jpg",
    "schedules": [],
    "show": false
  }
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

