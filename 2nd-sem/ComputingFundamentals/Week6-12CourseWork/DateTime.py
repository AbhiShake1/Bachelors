import datetime as dt
dt = dt.datetime.now()

#-> str is just an annotation telling what the method should return, doesn't affect anything
def getCurrentDate() -> str:
    '''gets current date in string'''
    return str(dt.date())

def getCurrentTime() -> str:
    '''gets current time in string'''
    return str(dt.time())