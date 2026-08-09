cat words.txt | tr -s ' ' '\n' | sort | uniq -c | sort -rn | awk '{print $2, $1}'

# cat words.txt → Reads the file.
# tr -s ' ' '\n' → Replaces spaces with newlines (-s squeezes repeated spaces).
# sort → Groups identical words together.
# uniq -c → Counts occurrences of each word.
# sort -rn → Sorts by frequency in descending numeric order.
# awk '{print $2, $1}' → Prints word count instead of count word.