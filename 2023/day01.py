

def parse_input(f):
    p1 = []
    p2 = []
    for line in f:
        line_type = type(line)
        curr_line1 = line_type().join(filter(line_type.isdigit, line))
        curr_string2 = get_better(line)
        line_type2 = type(curr_string2)
        curr_line2 = line_type2().join(filter(line_type2.isdigit, curr_string2))
        
        append(p1, curr_line1)
        append(p2, curr_line2)   
    return p1, p2

def append(l, s):
    if len(s) == 1:
        l.append(int(s + s))
    if len(s) > 1: 
        l.append(int(s[0] + s[-1]))
    return l

def get_better(l):
    res = (l.replace("one", "one1one")
    .replace("two","two2two")
    .replace("three","three3three")
    .replace("four", "four4four")
    .replace("five", "five5five")
    .replace("six", "six6six")
    .replace("seven", "seven7seven")
    .replace("eight", "eight8eight")
    .replace("nine", "nine9nine")
    .replace("zero", "zero0zero")
    )
    return res

def main():
    f = open("input/day01")
    p1, p2 = parse_input(f)
    print(sum(p1))
    print(sum(p2))

if __name__ == "__main__":
    main()