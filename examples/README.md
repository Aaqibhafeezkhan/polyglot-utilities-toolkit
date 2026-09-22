# Examples

These examples show one utility concept across multiple implementations without forcing identical APIs.

## Collections: unique values

The shared behavior is: remove duplicates while preserving the first occurrence of each value.

### JavaScript

```javascript
import { unique } from "../../utilities/collections/javascript/collection_utils.js";

const values = [3, 1, 3, 2, 1];
console.log(unique(values));
```

Expected result:

```text
[3, 1, 2]
```

### Python

```python
from utilities.collections.python.collection_utils import unique

values = [3, 1, 3, 2, 1]
print(unique(values))
```

### Java

```java
import io.polyglotutilities.collections.CollectionUtils;
import java.util.List;

var values = List.of(3, 1, 3, 2, 1);
var result = CollectionUtils.unique(values);
System.out.println(result);
```

### Go

```go
package main

import (
    "fmt"
    collections "polyglot-utilities/collections"
)

func main() {
    values := []int{3, 1, 3, 2, 1}
    fmt.Println(collections.Unique(values))
}
```

### Rust

```rust
use polyglot_utilities_collections::unique;

fn main() {
    let values = vec![3, 1, 3, 2, 1];
    println!("{:?}", unique(&values));
}
```

### C#

```csharp
using PolyglotUtilities.Collections;

var values = new[] { 3, 1, 3, 2, 1 };
Console.WriteLine(string.Join(", ", CollectionUtils.Unique(values)));
```

### Kotlin

```kotlin
import io.polyglotutilities.collections.CollectionUtils

val values = listOf(3, 1, 3, 2, 1)
println(CollectionUtils.unique(values))
```

The source language keeps its normal collection types and naming conventions. The compatibility contract is the resulting behavior, not a shared API signature.

## Where to find more examples

- Core fixture cases: [tests/matrix/fixtures/core-utility-cases.json](../tests/matrix/fixtures/core-utility-cases.json)
- Compatibility runner documentation: [docs/cross-language-test-matrix.md](../docs/cross-language-test-matrix.md)
- Utility contracts: [docs/cross-language-contracts.md](../docs/cross-language-contracts.md)
- Contributor workflow: [docs/contributing.md](../docs/contributing.md)

When adding a new public capability, prefer extending an existing capability example or adding a new capability-specific example rather than creating a language-first example tree.
