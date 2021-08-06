def count(word):
    v = 0
    c = 0
    for w in word:
        if 'a' in w or 'e' in w or 'i' in w or 'o' in w or 'u' in w:
            v += 1
        elif w.isalpha():
            c += 1
    return v,c #return tuple

#invoke
n = count(input("Enter a word: "))

#output
print(f"No. of vowels is {n[0]}\nNo. of consonents is {n[1]}")
