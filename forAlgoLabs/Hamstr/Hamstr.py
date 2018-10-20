def solver(list, greed, daily_food_supply, hamsters):
    consume_counter = 0
    i = 0

    while consume_counter <= daily_food_supply and i < hamsters:
        consume_counter = 0
        food_consume = [list[j] + greed[j] * i for j in range(0, len(list))]

        sorted_food = insertion_sort(food_consume)
        for j in range(0, i + 1):
            consume_counter += sorted_food[j]
        i += 1
    return i - 1


def insertion_sort(list):
    for i in range(1, len(list)):
        current_value = list[i]
        position = i

        while position > 0 and list[position - 1] > current_value:
            list[position] = list[position - 1]

            position = position - 1

            list[position] = current_value
    return list


def reader(filename):
    list = []
    with open(filename, "r") as input_file:
        daily_food_supply = int(input_file.readline())
        hamsters = int(input_file.readline())
        for i in range(0, hamsters):
            list.append([int(item) for item in input_file.readline().split()])

        list_bags = [item[0] for item in list]
        list_greed = [item[1] for item in list]

        return daily_food_supply, hamsters, list_bags, list_greed


def writer(filename, solution):
    with open(filename, "w") as output_file:
        output_file.write("{0}".format(solution))


def main():
    in_hamstr = "hamstr.in.txt"
    out_hamstr = "hamstr.out.txt"
    daily_food_supply, hamsters, feed_bags, greed = reader(in_hamstr)

    final_hamsters = solver(feed_bags, greed, daily_food_supply, hamsters)
    writer(out_hamstr, final_hamsters)


if __name__ == "__main__":
    main()
