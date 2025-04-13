```markdown
# Custom HashMap Implementation in Java

This project provides a custom implementation of `HashMap` in Java, mimicking the internal structure of Java 8's `HashMap`. It is aimed at understanding hashing, collision handling, and bit-level optimization for indexing. This can be a great resource for learning, interviews, or system design prep.

---

## ✨ Features

- Custom key-value storage
- Handles collisions using Linked List chaining
- Efficient hash computation and indexing
- Capacity is always a power of 2
- Designed to understand internal working of real HashMap

---

## 📦 Internal Structure

### Entity Class

Each bucket in the hash table is a singly linked list of `Entity<K, V>` nodes storing:
- Key
- Value
- Reference to next node (for chaining on collision)

---

## 🧠 Hash Computation & Indexing

### Hash Function

```java
int hash = (key == null) ? 0 : (hash = key.hashCode()) ^ (hash >>> 16);
```

- We take the `hashCode()` of the key and XOR it with its own value right-shifted by 16 bits.
- This spreads higher bits into lower bits.
- Prevents collision due to poorly distributed `hashCode()` implementations.

#### Why `^` (XOR) and not `+`, `|`, or others?
- XOR is non-redundant: if both bits are the same, it gives 0. If they differ, it gives 1.
- This keeps the resulting hash unpredictable and evenly distributed across bits.
- `|` or `+` would preserve patterns from the original hashCode, reducing entropy.

### Index Computation

```java
int index = (hashTable.length - 1) & hash;
```

- `(length - 1)` creates a bitmask when length is power of 2 (e.g., 16 becomes `0b1111`)
- `&` operation efficiently maps hash to valid index without `%` modulo operation
- Faster and more CPU cache-friendly

#### Example:

If table length = 16 (i.e., `0b10000`), `length - 1 = 15` (i.e., `0b01111`)

If hash = `0b10110101`  
Index = `0b10110101 & 0b00001111 = 0b00000101 = 5`

So we store this key-value pair at index 5.

---

## 🎯 Why Power of 2 Capacity?

To ensure `(length - 1)` acts as a valid bitmask for indexing.

### Capacity Function

```java
private final int getCapacity(int capacity) {
    int n = capacity - 1;
    n |= n >>> 1;
    n |= n >>> 2;
    n |= n >>> 4;
    n |= n >>> 8;
    n |= n >>> 16;
    return (n <= 0) ? 1 : (n >= MAXIMUM_SIZE) ? MAXIMUM_SIZE : n + 1;
}
```

#### Explanation:

- Reduces given capacity by 1 to handle exact powers of 2 correctly.
- Fills all bits to the right using bitwise OR and right shifts.
- Finally adds 1 to get the next power of 2.

#### Why 1, 2, 4, 8, 16?
- These shifts cover all 31 bits of a signed integer (`int`), since 1 bit is reserved for the sign.

#### Why max capacity is `2^30`?
- Max positive value of signed `int` = `2^31 - 1`
- To avoid overflow, the maximum capacity is capped at `2^30`

---

## 🧪 Testing

Sample test cases included:
- Insert, Get, Remove operations
- Collision scenarios
- Null keys
- Overwriting existing keys
- Resizing 

---

## ✅ Summary

| Concept                     | Approach                                                                 |
|----------------------------|--------------------------------------------------------------------------|
| Hash Distribution          | `(hashCode()) ^ (hashCode() >>> 16)` for bit spreading                   |
| Index Computation          | Bitwise AND: `(length - 1) & hash`, faster than `%`                      |
| Collision Handling         | Singly Linked List Chaining                                              |
| Capacity Normalization     | Rounded to nearest power of 2                                            |
| Performance Optimization   | Avoids expensive modulo, spreads hash bits to reduce collisions          |
| Max Capacity               | Capped at `2^30` to avoid integer overflow                               |

---

## 📝 Notes

- For large buckets, Java 8's real `HashMap` uses red-black trees — not implemented here for simplicity.
- This implementation is not thread-safe.

---

## 📚 Interview Concepts Covered

- Hashing and bitwise operations
- Bitmasking using `&` vs modulo
- XOR vs other operations for entropy
- Power of 2 logic in hash maps
- Collision resolution
- Linked List operations
- Capacity rounding logic

---

## 🙌 Contributions

Feel free to fork, raise issues, or submit PRs to improve or add new features.

---

## 🔖 License

This project is open-source and free to use for educational purposes.
```