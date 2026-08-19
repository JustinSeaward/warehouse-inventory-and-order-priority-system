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
    Referring to the example above my inorder sorting algorithm checks nodes from Left-Current-Right. Where Left is always smaller or equal to the Current, and the Right node is always bigger than the Current. So the algorithm will process the Left node first 2, then the Current which is 5, and then process the Right node which is 8, giving the user a inorder list of 2,5,8.

•	What is the time complexity of your algorithm?
•	When would your sorting algorithm perform well?
•	Why is your sorting algorithm ideal or not ideal for very large datasets?


System Design
•	Why might you choose to sort data in your application instead of the database?
•	What is one advantage of using a BST in this system?
•	What is one limitation of your current design?
