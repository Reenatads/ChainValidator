# Chain Validator

## Introduction
This project deals with the validation of two distinct types of lists, each tailored to accommodate specific types of values:

### List of Numbers
   - This type of list only contains numbers.
   - The numbers in the list can either be single-digit (like 3) or two-digit (like 24).
   - When we have a two-digit number (like 24), it depends on the presence of its individual digits (2 and 4).
   - For the number 24 to be valid in the list, both the digits 2 and 4 must also be present in the list.
### List of words and single characters
   - This list contains either words or single characters, all made up of lowercase letters from 'a' to 'z'.
   - Valid elements in this list can be words like "aba", "perso", or single characters like 'p', 'o', 's', etc.
   - Just like with the number list, multi-letter words in this list rely on their individual letters.
   - For example, the word "aba" depends on the presence of the letters 'a' and 'b' in the list.

 ## Dependencies
The program requires Java 17 and is built using Apache Maven.

## Usage
- Clone the repository to your local machine.
- Build the project using Maven

    ```BASH
    mvn clean install
    ```
- To run the unit tests use the following command

    ```BASH
    mvn clean test
    ```


