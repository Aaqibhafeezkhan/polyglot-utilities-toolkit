# Cross-Language Tutorial: Group Records by a Key

Grouping records is a common task: turn a flat list into buckets based on one field, such as team, category, or status. The toolkit exposes this behavior in JavaScript as `groupBy` and in Python as `group_by`.

## Example data

We have three tasks and want to group them by team.

### JavaScript

Run this from the repository root:

```javascript
import { groupBy } from "./utilities/collections/javascript/collection_utils.js";

const tasks = [
  { name: "Docs", team: "platform" },
  { name: "Login bug", team: "web" },
  { name: "API tests", team: "platform" }
];

console.log(groupBy(tasks, "team"));
```

Expected structure:

```javascript
{
  platform: [
    { name: "Docs", team: "platform" },
    { name: "API tests", team: "platform" }
  ],
  web: [
    { name: "Login bug", team: "web" }
  ]
}
```

### Python

```python
from utilities.collections.python.collection_utils import group_by

tasks = [
    {"name": "Docs", "team": "platform"},
    {"name": "Login bug", "team": "web"},
    {"name": "API tests", "team": "platform"},
]

print(group_by(tasks, "team"))
```

Expected structure:

```python
{
    "platform": [
        {"name": "Docs", "team": "platform"},
        {"name": "API tests", "team": "platform"},
    ],
    "web": [
        {"name": "Login bug", "team": "web"},
    ],
}
```

## What stays consistent?

- Each input record appears in the bucket matching its `team` value.
- Records within each bucket keep their original order.
- The original records are grouped; they are not sorted.

The API follows each language's conventions: JavaScript uses `groupBy(items, key)`, while Python uses `group_by(items, key)`. The goal is equivalent observable behavior, not identical spelling or return-type syntax.

## Try it yourself

1. Change `team` to `status` and group the tasks by status.
2. Add a third team and predict the result before running the code.
3. Try an empty list and confirm the result is an empty object/dictionary.

## Explore the project

- [All cross-language examples](../examples/README.md)
- [Collection utility implementations](../utilities/collections/)
- [Contributor guide](contributing.md)
- [First contribution quick start](first-contribution.md)
