word = input("Enter a word: ")

word = word.lower() #converting all letters to lower case

nVowels = 0
nConsonents = 0

for wo in word:
    if wo=="a" or wo=="e" or wo=="i" or wo=="o" or wo=="u":
        nVowels += 1
    elif wo.isalpha(): #alphabets other than vowels
        nConsonents += 1

#output
print(f"The number of vowels in given word is {nVowels}\n\tnumber of consonents is {nConsonents}")
