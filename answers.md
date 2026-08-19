Binary Search Tree
•	Why does an inOrder traversal of a BST return sorted results? Explain in your own words.
    - An inOrder traversal returns sorted results because the traversal works by visiting the left child, then printing the current node, and finally visiting the right child, you guarantee that the tree is read from the smallest value to the largest.

•	What happens to the tree if you insert values in order (1,2,3,4,5)? How does this affect    performance?
    - If you insert values inorder from 1,2,3,4,5 in a BST, when you start with 1 for the root and each value after is bigger then the root the values will be added to the right side causing a lopsided tree. This makes the time complexity go from logarithmic O(log n) time to a much slower liner time O(n) which is basically a list.

•	What is the difference between average and worst-case time complexity for a BST?
    - The different between an average and worse-case time complexity for a BST is O(n) and O(log n). Where a skewed left tree has to look through each node like a list to find the value, the time complexity ends up being O(n) where the search time grows compared to the amount of data. Compared to a AVL tree, when looking for a value the time complexity is only O(log n) because the tree forces itself to be balanced and you eliminate half of the remaining nodes with every single step you take through the tree.

•	Where would you place duplicate priority values in your tree? Explain your choice.
    - I decide to put the duplicate priorities on the left side of the node to keep with the FIFO rule. This works perfectly because my findHighest() method only travels down the right side of the tree looking for the highest priority. When a duplicate is on the left side the method stops at the parent node and process that node first before ever looking at the left side node.


Sorting Algorithm
•	Explain how your sorting algorithm works step-by-step using a small example.
        5
       / \
      2   8
    - Referring to the example above my inorder sorting algorithm checks nodes from Left-Current-Right. Where Left is always smaller or equal to the Current, and the Right node is always bigger than the Current. So the algorithm will process the Left node first 2, then the Current which is 5, and then process the Right node which is 8, giving the user a inorder list of 2,5,8.

•	What is the time complexity of your algorithm?
    - The time complexity of the algorithm to sortInOrder is O(n), linear time. Because the method has to visit every node one time to sort them for the list. So if there is ten orders there is ten nodes to visit and sort. If there are 100 orders it has to visit 100 nodes to sort. The time it takes matches the amount of data to sort. O(n) - linear time complexity.

•	When would your sorting algorithm perform well?
    - The sorting algorithm performs well when the orders come in with mixed up priority values rather than having them inserted into the tree in a sequence. Random values being inserted into the tree keeps the tree balanced and branching, keeping the time complexity to search and insert at O(log n) which in turn makes the sorting process efficient as well. 
    
•	Why is your sorting algorithm ideal or not ideal for very large datasets?
    - My current soring algorithm is not ideal for a large dataset unless orders come in with random priority values. I would need to make sure my BST adds orders to the tree and keeps itself balanced if it is to be effective for a large dataset.


System Design
•	Why might you choose to sort data in your application instead of the database?
    - I would choose to sort data in the application instead of the database to cut down on the calls to the database. You can make one call to the database when the system starts to receive and store the data you want to use and not 

•	What is one advantage of using a BST in this system?
    - One advantage of using a BST over a different method like an ArrayList in this system is the efficienty of inserting orders. If we used an ArrayList and needed to insert a high priority order at the top of the list, all other orders in the list would have to shift one place in memory which would give us a liner time O(n) complexity. In a BST nodes are inserted Left or Right of an existing node and doesn't have to move any existing data around giving the user a much faster insert time of O(log n) if the tree.

•	What is one limitation of your current design?
    - One limitation of my current design is the tree isn't self balancing. If orders are inserted into the tree in sequence the tree would become right side skewed making inserting and searching for data which gives us a linear time complexity O(n). If the tree was self balancing (AVL tree) the time complexity would become logarithmic O(log n) which is much faster and efficient.
