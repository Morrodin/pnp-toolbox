#!/usr/bin/python
#Copyright (c) 2013, Sierra Bravo Corp., dba The Nerdery.

import argparse
import csv
import re
import sqlite3
import sys

def santizeColumnName(name):
    replaceChars = ['(', ')']
    name = re.sub('[%s]' % ''.join(replaceChars), '', name)
    return name

def commonParse(filename):
    # Parsing logic taken from StackOverflow: http://stackoverflow.com/a/3428633/1610271
    f = open(filename, 'rb')
    reader = csv.reader(f)
    headers = reader.next()
    column = {}

    headers = map(santizeColumnName, headers)

    for header in headers:
        column[header] = []

    for row in reader:
        for h, v in zip(headers, row):
            column[h].append(str(v).decode('ascii', 'ignore'))

    return column

def parseFeatsFile(filename):
    column = commonParse(filename)

    del column['fulltext']

    return column

def parseMagicItemsFile(filename):
    column = commonParse(filename)

    del column['FullText']

    return column

def parseSpellsFile(filename):
    column = commonParse(filename)

    # Delete HTML-formatted columns, as saving them to the database is unecessarily difficult
    del column['full_text']
    del column['description_formated']

    return column

def parseTraitsFile(filename):
    column = commonParse(filename)

    return column

def writeToDb(dbName, tableName, data):
    conn = sqlite3.connect(dbName + '.sqlite')
    c = conn.cursor()

    # Remove existing table, if it exists
    c.execute('''DROP TABLE IF EXISTS ''' + tableName)

    # Create table
    # Surround the table and field names with quotes to allow for the use of keywords
    c.execute(('''CREATE TABLE "%s" ''' % tableName) + '''(%s)''' % ', '.join(map(lambda x : '"%s" text' % x, data.keys())))

    inserts = zip(*data.values())
    valsString = '('
    valsString += '?, ' * len(data.keys())
    valsString = valsString[:-2]
    valsString += ')'

    for dataLine in inserts:
        c.execute('''INSERT INTO ''' + tableName + ' values ' + valsString, dataLine)

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
    parser.add_argument('-d', '--database', type=str, default='database',
                       help='the name of the database to use')

    args = parser.parse_args()

    data = None

    if args.type == "spells":
        data = parseSpellsFile(args.input)
    elif args.type == "feats":
        data = parseFeatsFile(args.input)
    elif args.type == "magic_items":
        data = parseMagicItemsFile(args.input)
    elif args.type == "traits":
        data = parseTraitsFile(args.input)

    if data:
        writeToDb(args.database, args.type, data)


if __name__ == "__main__":
   main()