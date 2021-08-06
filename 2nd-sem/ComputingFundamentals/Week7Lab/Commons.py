def getCommon(word1, word2):
    word1 = set(word1)
    word2 = set(word2)
    print(word1.intersection(word2))

#invoke
w1 = input("Enter a word: ")
w2 = input("Enter another word: ")
getCommon(w1, w2)
