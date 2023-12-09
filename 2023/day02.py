import numpy as np

def parse_input(f):
    res = set()
    res2 = []
    
    for l in f:
        s1 = l.split(':')
        
        s2 = s1[1].split(';')
        gameid = s1[0].split()[1]
        res.add(gameid)
        fewest = [0,0,0]
        for item in s2:
            
            # print(fewest)

            s3 = item.split(',')
            # print(s3)
            for c in s3:
                
                amt = int(c[1])
                baseidx = 3
                if(c[2].isdigit()):
                    baseidx = 4
                    amt = 10 * amt + int(c[2])

              #  print(c[baseidx] + ' '+ str(amt))
                if c[baseidx] == 'r':
                    if fewest[0] < amt: 
                        fewest[0] = amt
                    if amt > 12:
                        res.discard(gameid)
                    
                if c[baseidx] == 'g':
                    if fewest[1] < amt: 
                        fewest[1] = amt
                    if amt > 13:
                        res.discard(gameid)
                     
                if c[baseidx] == 'b':
                    if fewest[2] < amt: 
                        fewest[2] = amt
                    if amt > 14:
                        res.discard(gameid)
            # print(fewest)
        prod = np.prod(fewest)
        # print(prod)
        res2.append(prod)
                    

    return res, res2     
        


def main():
    f = open("input/day02")
    p1, p2 = parse_input(f)
    p1_sum = 0
    p2_sum = 0
    for id in p1: 
        p1_sum = p1_sum + int(id)
    for sq in p2:
        p2_sum = p2_sum + int(sq)

    print(p1_sum)
    print(p2_sum)

if __name__ == "__main__":
    main()