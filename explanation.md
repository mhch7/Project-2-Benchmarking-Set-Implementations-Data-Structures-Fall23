Results: 


Benchmarking insertRandoms:

Time to insert 10 random numbers: 720691 nanoseconds

Time to insert 10 random numbers: 1068718 nanoseconds

Time to insert 10 random numbers: 44254 nanoseconds


Benchmarking insertIn0rder:

Time to insert numbers from 0 to 9 in order: 68610 nanoseconds 

Time to insert numbers from 0 to 9 in order: 71167 nanoseconds 

Time to insert numbers from 0 to 9 in order: 47912 nanoseconds


Benchmarking containsRandom:

Time to perform 10 random contains: 50769 nanoseconds 

Time to perform 10 random contains: 35062 nanoseconds

Time to perform 10 random contains: 61322 nanoseconds


Benchmarking containsIn0rder:

Time to perform 10 ordered contains:40185 nanoseconds

Time to perform 10 ordered contains: 44923 nanoseconds 

Time to perform 10 ordered contains: 49861 nanoseconds


Benchmarking insertRandoms:

Time to insert 100 random numbers: 1121698 nanoseconds

 Time to insert 100 random numbers: 1497842 nanoseconds 

Time to insert 100 random numbers: 2632968 nanoseconds


Benchmarking insertInOrder:

Time to insert numbers from 0 to 99 in order: 1253952 nanoseconds

Time to insert numbers from 0 to 99 in order: 897847 nanoseconds

Time to insert numbers from 0 to 99 in order: 368978 nanoseconds


Benchmarking containsRandom:

Time to perform 100 random contains: 632219 nanoseconds

Tims to perform 100 random contains:177418 nanoseconds

Tim to perform 100 random contains: 721384 nanoseconds


Berichmarking containsInOrder:

Time to perform 100 ordered contains: 298962 nanoseconds

Time to perform 100 ordered contains: 67806 nanoseconds

Time to perform 100 ordered contains: 455257 nanoseconds


Benchmarking insertRandoms:

Time to insert 10000 random numbers: 96184186 nanoseconds 

Time to insert 10000 random numbers: 14706116 nanoseconds

Time to insert 10000 random numbers: 8796546 nanoseconds


Benchmarking insertIn0rder:

Time to insert numbers from 0 to 9999 in order: 259640839 nanoseconds 

Time to insert numbers from 0 to 9999 in order: 17833027 nanosecond 

Time to insert numbers from 0 to 9999 in order: 1022434064 nanoseconds


Benchmarking containsRandom:

Time to perform 10000 random contains: 198604294 nanoseconds

Time to perform 10000 random contains: 6619995 nanoseconds

Time to perform 10000 random contains: 344762390 nanoseconds


Benchmarking containsIn0rder:

Time to perform 10000 ordered contains: 225305052 nanoseconds

Time to perform 10000 ordered contains: 2003618 nanoseconds

Time to perform 10000 ordered contains: 307801740 nanoseconds


For the insert random method, the BST was the fastest for the first two tests, but as the input got larger BST slowed significantly, showing array lists are the best for large unordered inputs. The same theme follows for the insert random method for BST, however, AVL tree ended up being the fastest for large-ordered inputs. For the contains random method the AVL tree was the fastest across the board. For the contains-in order method array list was just marginally faster for the first test, however AVL tree ended up being faster for the larger data. Based on this, I’d say AVL trees are the most efficient data structure, especially for the larger data, whether data is ordered or not.
