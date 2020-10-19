### Refactoring Steps:
1. Remove unused imports
1. Remove logic from if block
1. Rename arr to words
1. Rename Input class to WordFrequency and change field names to word and frequency
1. Remove extra spaces in WordFrequency class
1. Improve WordFrequency constructor parameters by changing them to word and frequency
1. Set WordFrequency fields to final
1. Rename s to word
1. Auto-format code in IDE
1. Rename map to wordFrequencyMap
1. Remove comments
1. Rename w1 and w2 to firstWord and secondWord
1. Make a constant for \n
1. Rename w to wordFrequency
1. Rename s to wordFrequencyLine
1. Replace concatenation with String.format
1. Make a constant for \s+
1. Remove unnecessary try-catch block
1. Rename inputStr to sentence
1. Extract splitting and populating word frequencies to method
1. Simplify logic of extractWordFrequencies()
1. Remove unused method
1. Extract word frequency lines joining to method
1. Simplify buildWordFrequencyLines() logic
1. Remove unused imports
1. Change String.format and Collectors.joining importing to static import and remove unused imports
1. Place constructing of word frequency line in WordFrequency class
1. Replace foreach with map and place it in inline in return statement
1. Simplify usage of sort by utilizing reverseOrder and comparingInt
1. Change field modifiers to private
1. Change constants to local variables
1. Use static import for Collectors.toList()
1. Remove unused imports
1. Remove unused getter
1. Rearrange code entries automatically using IDE
1. Remove unnecessary throws in test
1. Change sentence to phrase
1. Change inputStr to inputPhrase in test
1. Test: Test if WordFrequencyGame.getResult() will return "Calculate Error" if null is provided
1. Feature: Wrap getResult() logic in try-catch and return "Calculate Error" in catch
1. Remove unused imports