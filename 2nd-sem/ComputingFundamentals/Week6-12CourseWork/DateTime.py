import datetime  # library from python api. Not user defined

__dt = datetime.datetime.now()


# -> str is just an annotation telling what the method should return, doesn't affect anything
def getCurrentDate() -> str:
    """gets current date in string"""
    return str(__dt.date())


def getCurrentTime() -> str:
    """gets current time in string"""
    return str(__dt.time())


def getDate() -> datetime:
    """helps check if user should be charged extra"""
    date = getCurrentDate().split('-')
    return datetime.date(int(date[0]), int(date[1]), int(date[2]))


def getBorrowedDate(file) -> datetime:
    f = open(file)  # open in read mode
    lines = f.readlines()
    f.close()
    for data_line in lines:
        if 'Date:' in data_line:
            # remove useless info, strip down spaces, line breaks and convert to array
            data = data_line.strip().strip('Date:').strip('\n').split('-')
            return datetime.date(int(data[0]), int(data[1]), int(data[2]))
