/*
 * Copyright 2019 vmadalin.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package app.oneecom.core.bindings

import android.graphics.Paint
import android.widget.TextView
import androidx.databinding.BindingAdapter

/**
 * Enable or disable strike thru paint text flag.
 *
 * @param strike true if you want to enable [Paint.STRIKE_THRU_TEXT_FLAG]
 * @see [https://stackoverflow.com/a/9786629/2437655]
 */
@BindingAdapter("strike")
fun TextView.strike(strike: Boolean) {
    if (strike) {
        paintFlags = paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
    } else {
        paintFlags = paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
    }
}
