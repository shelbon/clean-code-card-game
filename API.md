## Api Route
```bash
  #  genrate one hero or many
  POST     /generate/hero
  POST    /generate/heroes?numberOfHeroes=
  # create a player
  POST   /players
  # pull card from a card pack
  POST  /cards
  #
  POST /card-pack/fill-random
```
##  /generate/hero
input: none

output example: 
```json
{
  "status": "OK",
  "timestamp": "26-02-2023 06:45:50",
  "payload": [
    {
      "id": 17,
      "name": "Halina Ernser PhD",
      "health": 1,
      "attackPoints": 0,
      "armorPoints": 20,
      "level": 100,
      "rarity": {
        "id": 20,
        "name": "RARE"
      },
      "speciality": {
        
      }
    }
  ]
}
```
## /generate/heroes
param numberOfHeroes :   number of hero to generate

output example:
```json
{
  "status": "OK",
  "timestamp": "26-02-2023 10:22:59",
  "payload": [
    {
      "id": 11,
      "name": "Mose Satterfield Jr.",
      "health": 700,
      "attackPoints": 150,
      "armorPoints": 10,
      "level": 1,
      "rarity": {
        "id": 14,
        "name": "COMMON"
      },
      "speciality": {}
    }
  ]
}
```
##  /players
input:
    username : username of player to create

output example:
```json
{
  "status": "CREATED",
  "timestamp": "26-02-2023 06:45:54",
  "payload": {
    "id": 1,
    "username": "bob"
  }
}
```

##  /cards
input:
userId : username of player to create
 packId: card pack id ,
numberOfPulls: number of pull

output example:
```json
{
  "status": "OK",
  "timestamp": "26-02-2023 10:30:34",
  "payload": [
    {
      "id": 3,
      "name": "Cheryl Grady DDS",
      "health": 700,
      "attackPoints": 150,
      "armorPoints": 10,
      "level": 1,
      "rarity": {
        "id": 6,
        "name": "COMMON"
      },
      "speciality": {}
    },
    {
      "id": 3,
      "name": "Cheryl Grady DDS",
      "health": 700,
      "attackPoints": 150,
      "armorPoints": 10,
      "level": 1,
      "rarity": {
        "id": 6,
        "name": "COMMON"
      },
      "speciality": {}
    },
    {
      "id": 3,
      "name": "Cheryl Grady DDS",
      "health": 700,
      "attackPoints": 150,
      "armorPoints": 10,
      "level": 1,
      "rarity": {
        "id": 6,
        "name": "COMMON"
      },
      "speciality": {}
    }
  ]
}
```

##  /card-pack/fill-random
input:
cardPackId: id of a pack of cards
numberOfCard : number of cards

output example:
```json
{
  "status": "OK",
  "timestamp": "27-02-2023 12:06:06",
  "payload": {
    "id": 1,
    "name": "Pack Argent",
    "cards": [
      {
        "id": 1,
        "name": "Suk Fahey",
        "health": 1000,
        "attackPoints": 100,
        "armorPoints": 20,
        "level": 1,
        "rarity": {
          "id": 4,
          "name": "RARE"
        },
        "speciality": {}
      },
      {
        "id": 2,
        "name": "Monroe Kerluke Jr.",
        "health": 700,
        "attackPoints": 150,
        "armorPoints": 10,
        "level": 1,
        "rarity": {
          "id": 5,
          "name": "LEGENDARY"
        },
        "speciality": {}
      },
      {
        "id": 3,
        "name": "Jc McClure",
        "health": 700,
        "attackPoints": 150,
        "armorPoints": 10,
        "level": 1,
        "rarity": {
          "id": 6,
          "name": "RARE"
        },
        "speciality": {}
      },
      {
        "id": 4,
        "name": "Gaye Mertz",
        "health": 1000,
        "attackPoints": 100,
        "armorPoints": 20,
        "level": 1,
        "rarity": {
          "id": 7,
          "name": "LEGENDARY"
        },
        "speciality": {}
      },
      {
        "id": 5,
        "name": "Mr. Sonny Labadie",
        "health": 700,
        "attackPoints": 150,
        "armorPoints": 10,
        "level": 1,
        "rarity": {
          "id": 8,
          "name": "RARE"
        },
        "speciality": {}
      },
      {
        "id": 6,
        "name": "Chere Abshire",
        "health": 1000,
        "attackPoints": 100,
        "armorPoints": 20,
        "level": 1,
        "rarity": {
          "id": 9,
          "name": "RARE"
        },
        "speciality": {}
      },
      {
        "id": 7,
        "name": "Marceline Deckow",
        "health": 700,
        "attackPoints": 150,
        "armorPoints": 10,
        "level": 1,
        "rarity": {
          "id": 10,
          "name": "RARE"
        },
        "speciality": {}
      }
    ],
    "tokenCost": 1,
    "cardCount": 3,
    "cardPackRarities": [
      {
        "rarity": {
          "id": 1,
          "name": "COMMON"
        },
        "rate": 0.75
      },
      {
        "rarity": {
          "id": 2,
          "name": "RARE"
        },
        "rate": 0.2
      },
      {
        "rarity": {
          "id": 3,
          "name": "LEGENDARY"
        },
        "rate": 0.05
      }
    ]
  }
}
```