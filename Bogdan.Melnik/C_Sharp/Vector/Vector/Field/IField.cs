using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Vector.Field
{
    interface IField 
    {
        public static IField operator+(IField lhs,IField rhs);
    }
}
