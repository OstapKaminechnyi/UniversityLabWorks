from timeit import default_timer as timer


class Camera:
    brand_name, amount_of_memory, zoom_multiplicity = "", 0, 0

    def get_amount(self):
        return int(self.amount_of_memory)

    def get_zoom(self):
        return int(self.zoom_multiplicity)

    def __repr__(self):
        print("Brand name: " + self.brand_name + ", Amount of memory: " + str(self.amount_of_memory)
              + ". Zoom multiplicity: " + str(self.zoom_multiplicity))


def __init__(self, brand_name, amount_of_memory, zoom_multiplicity):
    self.brand_name = brand_name
    self.amount_of_memory = amount_of_memory
    self.zoom_multiplicity = zoom_multiplicity


ins_comparisons = 0
ins_swaps = 0


def insertion_sort(list):

    ins_comparisons = 0
    ins_swaps = 0

    for i in range(1, len(list)):
        current_value = list[i]
        position = i

        while position > 0 and list[position - 1].get_amount() < current_value.get_amount():
            ins_comparisons += 1
            ins_swaps += 1
            list[position] = list[position - 1]  # switch

            position = position - 1

            list[position] = current_value

    print("comparisons:" + str(ins_comparisons), "swaps:", str(ins_swaps))



def merge_sort(list):


    if len(list) <= 1:
        return list
    mid = int(len(list) // 2)
    list_part = merge_sort(list[:mid])
    right_part = merge_sort(list[mid:])
    return merge(list_part, right_part)


def merge(list1, list2):
    array = []
    list1_len = len(list1)
    list2_len = len(list2)
    lpart_value = 0
    rpart_value = 0

    mer_comparisons = 0
    mer_swaps = 0
    while lpart_value < list1_len and rpart_value < list2_len:
        mer_comparisons += 1
        if list1[lpart_value].get_zoom() <= list2[rpart_value].get_zoom():
            array.append(list1[lpart_value])
            lpart_value += 1
            mer_swaps +=1
        else:
            array.append(list2[rpart_value])
            rpart_value += 1
            mer_swaps +=1
    while lpart_value < list1_len:
        array.append(list1[lpart_value])
        lpart_value += 1
        mer_swaps +=1
    while rpart_value < list2_len:
        array.append(list2[rpart_value])
        rpart_value += 1
        mer_swaps +=1
    return array





def file_to_list(file):
    file = open(file)
    list_of_cameras = []
    for line in file:
        line = line.split(", ")
        obj = Camera()
        obj.brand_name = line[0]
        obj.amount_of_memory = int(line[1])
        obj.zoom_multiplicity = int(line[2])
        list_of_cameras.append(obj)
    return list_of_cameras


def main():
    cameras_file = file_to_list('cameras.txt')

    cameras_file = merge_sort(cameras_file)
    start = timer()

    insertion_sort(cameras_file)
    end = timer()
    print("insertion time=" + str(end - start))

    print("Insertion sort:\n")
    for obj in cameras_file:
        obj.__repr__()


    start1 = timer()
    cameras_file = merge_sort(cameras_file)
    end1 = timer()
    print("merge time=" + str(end1 - start1))

    print("Merge sort:\n")
    for obj in cameras_file:
        obj.__repr__()




if __name__ == '__main__':
    main()
