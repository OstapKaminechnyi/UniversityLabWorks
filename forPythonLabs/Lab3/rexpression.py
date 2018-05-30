import re


def search():
    file = open('logs')
    pattern = '0[7-8]/Mar/2004:[0-2][0-9]:[0-5][0-9]:[0-5][0-7].*GET.*\.ico.*200'
    for line in file:
        match = re.search(pattern, line)
        if match:
            print(match.group())
    file.close()


if __name__ == "__main__":
    search()


#07/Mar/2004:02:12:57 до 08/Mar/2004:21:02:12