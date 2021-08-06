def isPalindrome(word):
    #r = word[::-1] #read from end to start
    ''' #O(N)
    r = ""
    for w in word:
        r = w + r #perpending to r
    '''
    #return word==r
    #O(logN)
    s = 0
    e = len(word)-1
    while s < e:
        if word[s] == word[e]:
            s+=1
            e-=1
        else:
            return False
    return True

#check
word = input("Enter a word: ")
if isPalindrome(word):
    print(word, "is palindrome")
else:
    print(word, "is not palindrome")
