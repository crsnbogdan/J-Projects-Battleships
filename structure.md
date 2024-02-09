    Classes:
    1. SimpleGame.SimpleGame
       Setup:
        Initialization:
            - Creates a new User instance, prompting the user to enter their name via the console.
            Instantiates a GameShip object with a length of 3. The ship's starting position is randomly generated, ensuring it lies between indices 0 and 7 in a virtual array of 10 elements.
            The ship is oriented horizontally within the array. - DONE

        Gameplay:
            - Continuously checks the state of the GameShip:
            - If a guess is a miss, the game continues.
            - If a guess hits but the ship is not sunk, the game continues.
            - If the ship is sunk (all parts hit), the game ends.
            - Prompts the user to input a guess for the ship's location. Only integer inputs are accepted (validating for range and format).
            - If a location is guessed more than once, informs the user and prompts for a new guess without incrementing the move counter.
            Maintains a count of the number of guesses made.

        End:
            - The game concludes when the ship is sunk.
            - Displays the total number of hits required to sink the ship.

    2. User
            - Stores the user's name. - DONE
            - Includes a method to input a guess for the ship's position in the virtual array.

    3. GameShip 
            - Accepts a specified length and startIndex during initialization. - DONE
            - Keeps track of the number of hits it has received.
            - Prevents the same location from being hit more than once.
            - Determines its sunk state when all its positions have been hit.