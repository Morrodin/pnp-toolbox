#!/usr/bin/python
#Copyright (c) 2013, Sierra Bravo Corp., dba The Nerdery.

import argparse
import csv
import sqlite3
import sys

def parseSpellsFile(filename):
    # Parsing logic taken from StackOverflow: http://stackoverflow.com/a/3428633/1610271
    f = open(filename, 'rb')
    reader = csv.reader(f)
    headers = reader.next()
    column = {}

    for header in headers:
        column[header] = []

    for row in reader:
        for h, v in zip(headers, row):
            column[h].append(str(v).decode('ascii', 'ignore'))

    # Delete HTML-formatted columns, as saving them to the database is unecessarily difficult
    del column['full_text']
    del column['description_formated']

    return column

def writeToDb(dbName, data):
    conn = sqlite3.connect(dbName + '.sqlite')
    c = conn.cursor()

    # Create table
    c.execute('''CREATE TABLE IF NOT EXISTS ''' + dbName + '''(''' + ' text, '.join(data.keys()) + ' text' + ''')''')

    inserts = zip(*data.values())
    valsString = '('
    valsString += '?, ' * len(data.keys())
    valsString = valsString[:-2]
    valsString += ')'

    for dataLine in inserts:
        c.execute('''INSERT INTO ''' + dbName + ' values ' + valsString, dataLine)

    # Save (commit) the changes
    conn.commit()

    # We can also close the connection if we are done with it.
    # Just be sure any changes have been committed or they will be lost.
    conn.close()


def main():
    parser = argparse.ArgumentParser(description='Create a database from a CSV file.')
    parser.add_argument('-i', '--input', type=str,
                       help='the name of the input CSV file')
    parser.add_argument('-t', '--type', type=str,
                       help='the type of the input CSV file, e.g. spells')

    args = parser.parse_args()

    data = None

    if args.type == "spells":
        data = parseSpellsFile(args.input)

    if data:
        writeToDb(args.type, data)


if __name__ == "__main__":
   main()