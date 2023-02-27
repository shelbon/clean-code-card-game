# Clean code card game

clean code project for the 4th year last term at ESGI.

A basic card game  with some gacha element.

- Card have a rarity and speciality
- the party is between one card of the player vs one of the opponent
- each five battle the player  gain a gacha token

## Tech Stack

**Client:** nothing for now

**Server:** Spring boot,java

## Api Route

```bash
  #  genrate one hero or many
  POST     /generate/hero
  POST    /generate/heroes
  # create a player
  POST   /players 
  # pull card from a card pack
  POST  /cards
```

detail of the api [there](API.md)

## Run locally

A embedded database is present(H2)
run the project 
```bash
#windows
./gradlew.bat bootrun
#linux
./gradlew bootrun

```