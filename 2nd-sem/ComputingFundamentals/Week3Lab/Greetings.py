day = input("Enter current day of the week: ")
day = day.lower(); #convert input to lower case

if not "day" in day: #check if it contains "day" in a sequence
   print("Not a valid week of the day")
   
elif day.startswith("sat"):
   print("Enjoy your weekend!")
   
else:
    print("Happy weekdaay! Work hard!")
