# tr标签不能嵌套的解决方案

* 由于tr标签不能嵌套，用td标签嵌套div标签来代替tr标签的嵌套
    ```html
    <table id="storeTable" class="displayStore" border="1">
      <tr>
        <td>
          <div align="center">

          </div>
          <div align="center">

          </div>
          <div align="center">

          </div>
          <div align="center">

          </div>
        </td>
    </tr>
  </table>
  ```
